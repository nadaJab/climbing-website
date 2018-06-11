package action;
import com.opensymphony.xwork2.ActionSupport;

public class AjoutRouteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nameLigne;
	private String cotation;
	private Double height;
	private int pointNumber;
	private String nomOuvreurs;
	private int openingYear;
	
	public String execute() {
		return SUCCESS;	
	}

	public String getNameLigne() {
		return nameLigne;
	}

	public void setNameLigne(String nameLigne) {
		this.nameLigne = nameLigne;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public int getPointNumber() {
		return pointNumber;
	}

	public void setPointNumber(int pointNumber) {
		this.pointNumber = pointNumber;
	}

	public String getNomOuvreurs() {
		return nomOuvreurs;
	}

	public void setNomOuvreurs(String nomOuvreurs) {
		this.nomOuvreurs = nomOuvreurs;
	}

	public int getOpeningYear() {
		return openingYear;
	}

	public void setOpeningYear(int openingYear) {
		this.openingYear = openingYear;
	}
}
