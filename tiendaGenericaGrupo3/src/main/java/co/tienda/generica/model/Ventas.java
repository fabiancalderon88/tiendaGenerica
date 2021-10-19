package co.tienda.generica.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Ventas {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigo_venta;
	private Integer cedula_cliente;
	private Integer cedula_usuario;
	private Integer  ivaventa;
	private Double total_venta;
	private Double valor_venta;	

	
	public Ventas() {
		super();
		
	}	
		

	public Integer getCodigo_venta() {
		return codigo_venta;
	}


	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}


	public Integer getCedula_cliente() {
		return cedula_cliente;
	}


	public void setCedula_cliente(Integer cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}


	public Integer getCedula_usuario() {
		return cedula_usuario;
	}


	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}


	public Integer getIvaventa() {
		return ivaventa;
	}


	public void setIvaventa(Integer ivaventa) {
		this.ivaventa = ivaventa;
	}


	public Double getTotal_venta() {
		return total_venta;
	}


	public void setTotal_venta(Double total_venta) {
		this.total_venta = total_venta;
	}


	public Double getValor_venta() {
		return valor_venta;
	}


	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}


	/*@Override
	public String toString() {
		return "venta [codigo_producto=" + codigo_producto + ", ivacompra=" + ivacompra + ", nitproveedor="
				+ nitproveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + "]";
	}*/
	
}