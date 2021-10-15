package co.tienda.generica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigo_producto;
	private Double ivacompra;
	private Integer nitproveedor;
	private String nombre_producto;
	private Double precio_compra;
	private Double precio_venta;	
	private String active;
	
	public Producto() {
		super();
		
	}	
		
	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public Integer getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Integer nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}	
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Producto(Integer codigo_producto, Double ivacompra, Integer nitproveedor, String nombre_producto,
			Double precio_compra, Double precio_venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "Producto [codigo_producto=" + codigo_producto + ", ivacompra=" + ivacompra + ", nitproveedor="
				+ nitproveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + "]";
	}
	
}