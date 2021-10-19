package co.tienda.generica.controller;


	import java.util.*;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	 
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.*;
	import org.springframework.web.multipart.MultipartFile;
	import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
	import org.springframework.web.servlet.mvc.support.RedirectAttributes;
	 
	@Controller
	public class UploadController{
	 
	    private String filename;
	    //Save the uploaded file to this folder
	    private static String UPLOADED_FOLDER = "/src/main/resources/static/img/";
	 
	    /*
	    ** Página de carga de archivos
	     */
	 
	    @GetMapping("/upload")
	    public String upload(){
	        return "upload";
	    }
	 
	    @PostMapping("/upload")
	    public String singleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) {
	 
	        if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "¡El archivo está vacío! ¡Seleccione un archivo no vacío para cargar!");
	            return "redirect:/uploadStatus";
	        }
	 
	        try {
	            // Obtenga el archivo y guárdelo en la carpeta especificada
	            byte[] bytes = file.getBytes();
	            filename = file.getOriginalFilename();
	            Path path = Paths.get(UPLOADED_FOLDER + filename);
	            Files.write(path, bytes);
	 
	            redirectAttributes.addFlashAttribute("message", "Has subido correctamente" + filename + "', el tamaño del archivo es aproximadamente" +bytes.length/1024+" KB.");
	 
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	 
	        return "redirect:/uploadStatus";
	    }
	 
	    /*
	         ** Página de procesamiento de información de carga de archivos
	     */
	    @GetMapping("/uploadStatus")
	    public String uploadStatus(){
	        return "uploadStatus";
	    }
	 
	    /*
	         ** Página de vista previa de datos: admite la vista previa de archivos CSV y algunos formatos de imagen
	     */
	 
	    @GetMapping("/review")
	    public String review(Map<String, Object> map) {
	 
	        map.put("filename", filename);
	        String filetype = filename.split("\\.")[1];
	        map.put("filetype",filetype);
	        System.out.println(filename);
	 
	        if(filetype.equals("csv")) {
	            readCSV read_csv = new readCSV(UPLOADED_FOLDER + filename);
	            List<String> result = read_csv.read();
	            map.put("result", result);
	        }
	 
	        return "review";
	    }
	 
	}
