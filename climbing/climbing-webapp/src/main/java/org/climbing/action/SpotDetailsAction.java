package org.climbing.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.ArrayList;
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

public class SpotDetailsAction extends ActionSupport{

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
	private ArrayList<Topo> topos;
	private Topo topoBean;

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
		LOGGER.debug(topoBean.toString() + "@@");
		vResult = ActionSupport.SUCCESS;	

		return vResult;

	}

}
