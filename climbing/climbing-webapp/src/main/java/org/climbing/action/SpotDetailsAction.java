package org.climbing.action;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.servlet.ServletRequestAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.comment.Comment;
import org.climbing.model.beans.spot.Route;
import org.climbing.model.beans.spot.Sector;
import org.climbing.model.beans.spot.Spot;
import org.climbing.model.beans.topo.Topo;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class SpotDetailsAction extends ActionSupport implements ServletRequestAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(SpotDetailsAction.class);

	private Spot spotBean;
	private Integer idSpot;
	private Integer idSector;
	private Integer idTopo;
	private ArrayList<Sector> sectors;
	private ArrayList<Route> lignes;
	private ArrayList<Comment> comment;
	private ArrayList<Comment> commentTopo;
	private ArrayList<Topo> topos;
	private Topo topoBean;
	private  File[] files;
	private HttpServletRequest servletRequest;
	
	@Autowired
	private ManagerFactory managerFactory;

	public String execute() {
		return SUCCESS;	
	}

	public Spot getSpotBean() {
		return spotBean;
	}

	public void setSpotBean(Spot spotBean) {
		this.spotBean = spotBean;
	}

	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}

	public ArrayList<Sector> getSectors() {
		return sectors;
	}

	public void setSectors(ArrayList<Sector> sectors) {
		this.sectors = sectors;
	}

	public ArrayList<Route> getLignes() {
		return lignes;
	}

	public void setLignes(ArrayList<Route> lignes) {
		this.lignes = lignes;
	}

	public Integer getIdSector() {
		return idSector;
	}

	public void setIdSector(Integer idSector) {
		this.idSector = idSector;
	}

	public ArrayList<Comment> getComment() {
		return comment;
	}

	public void setComment(ArrayList<Comment> comment) {
		this.comment = comment;
	}

	public ArrayList<Topo> getTopos() {
		return topos;
	}

	public void setTopos(ArrayList<Topo> topos) {
		this.topos = topos;
	}

	public Topo getTopoBean() {
		return topoBean;
	}

	public void setTopoBean(Topo topoBean) {
		this.topoBean = topoBean;
	}

	public Integer getIdTopo() {
		return idTopo;
	}

	public void setIdTopo(Integer idTopo) {
		this.idTopo = idTopo;
	}

	public ArrayList<Comment> getCommentTopo() {
		return commentTopo;
	}

	public void setCommentTopo(ArrayList<Comment> commentTopo) {
		this.commentTopo = commentTopo;
	}


	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public String searchSpotDetails() {
		String vResult = ActionSupport.INPUT;

		spotBean = managerFactory.getSpotManager().getSpotId(idSpot);
		sectors = managerFactory.getSectorManager().getAllSectors(idSpot);
		comment = managerFactory.getCommentSpotManager().getAllComment(idSpot);
		topos = managerFactory.getTopoManager().getAllTopo(idSpot);

		LOGGER.debug(spotBean.toString() + "§§§§§");

		vResult = ActionSupport.SUCCESS;	

		return vResult;
	}

	/**
	 * Action "AJAX" renvoyant la liste des voies
	 * @return success
	 */
	public String doAjaxGetListRoute() {
		String vResult = ActionSupport.INPUT;
		LOGGER.debug(idSector + "*****");
		lignes = managerFactory.getRouteManager().getAllRoute(idSector);
		vResult = ActionSupport.SUCCESS;	

		return vResult;
	}

	public String getTopo() {
		String vResult = ActionSupport.INPUT;
		topoBean = managerFactory.getTopoManager().getTopo(idTopo);
		commentTopo = managerFactory.getCommentTopoManager().getAllComment(idTopo);
		LOGGER.debug(topoBean.toString() + "@@");
		
		String rep = String.valueOf(topoBean.getIdTopo());
		String docPath = "C:\\Users\\nadas\\Documents\\formation-openclassrooms-P6\\climbing-website-master\\climbing\\climbing-webapp\\src\\main\\webapp\\images\\images-topo";
	
		File file = new File(docPath + "/" + rep +"/");
		
		files=file.listFiles(); 
		LOGGER.debug( Arrays.toString(files) + "%%");
		vResult = ActionSupport.SUCCESS;	

		return vResult;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

	@Override
	public String toString() {
		return "SpotDetailsAction [files=" + Arrays.toString(files) + "]";
	}

}
