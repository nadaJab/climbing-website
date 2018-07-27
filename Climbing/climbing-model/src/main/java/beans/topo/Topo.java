package beans.topo;

import java.util.Date;

public class Topo {
	
	private Integer id_topo;
	private String topo_name;
	private String author;
	private Integer nb_copy_max;
	private Date edition_year;
	private Date published;
	private String image_URL;
	
	
	public Integer getId_topo() {
		return id_topo;
	}
	public void setId_topo(Integer id_topo) {
		this.id_topo = id_topo;
	}
	public String getTopo_name() {
		return topo_name;
	}
	public void setTopo_name(String topo_name) {
		this.topo_name = topo_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNb_copy_max() {
		return nb_copy_max;
	}
	public void setNb_copy_max(Integer nb_copy_max) {
		this.nb_copy_max = nb_copy_max;
	}
	public Date getEdition_year() {
		return edition_year;
	}
	public void setEdition_year(Date edition_year) {
		this.edition_year = edition_year;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public String getImage_URL() {
		return image_URL;
	}
	public void setImage_URL(String image_URL) {
		this.image_URL = image_URL;
	}
	
	
}
