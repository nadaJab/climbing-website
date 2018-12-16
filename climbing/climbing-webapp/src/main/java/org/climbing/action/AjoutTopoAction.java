package org.climbing.action;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.climbing.business.contract.ManagerFactory;
import org.climbing.model.beans.topo.Topo;
import org.climbing.model.beans.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class AjoutTopoAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LogManager.getLogger(AjoutTopoAction.class);

	private Topo topoBean;
	private Integer idSpot;

	private Map<String, Object> session;
	private static final String USER = "user";

	private ArrayList<File> uploads;
	private ArrayList<String> uploadFileNames;
	private ArrayList<String> uploadContentTypes;
	
	private String uploadsPath;

	@Autowired
	private ManagerFactory managerFactory;
	
	public String execute() {
		String uploadsPath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");  
		LOGGER.debug("uploads location: " + uploadsPath);
		
		 // copy the uploaded files into pre-configured location
        for (int i = 0; i < uploads.size(); i++) {
            File uploadedFile = uploads.get(i);
            String fileName = uploadFileNames.get(i);
            File destFile = new File(uploadsPath + File.separator + fileName);
            try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException ex) {
                System.out.println("Could not copy file " + fileName);
                ex.printStackTrace();
            }
        }
		return SUCCESS;	
	}

	public ArrayList<File> getUpload() {
		return this.uploads;
	}
	public void setUpload(ArrayList<File> upload) {
		this.uploads = upload;
	}
	public ArrayList<String> getUploadFileName() {
		return this.uploadFileNames;
	}
	public void setUploadFileName(ArrayList<String> uploadFileName) {
		this.uploadFileNames = uploadFileName;
	}
	public ArrayList<String> getUploadContentType() {
		return this.uploadContentTypes;
	}
	public void setUploadContentType(ArrayList<String> uploadContentType) {
		this.uploadContentTypes = uploadContentType;
	}

	public Topo getTopoBean() {
		return topoBean;
	}

	public void setTopoBean(Topo topoBean) {
		this.topoBean = topoBean;
	}

	public Integer getIdSpot() {
		return idSpot;
	}

	public void setIdSpot(Integer idSpot) {
		this.idSpot = idSpot;
	}
	
	public String getUploadsPath() {
		return uploadsPath;
	}

	public void setUploadsPath(String uploadsPath) {
		this.uploadsPath = uploadsPath;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;	
	}

	/*
	public String doAddTopo() {
		String vResult = ActionSupport.INPUT;	
		
		topoBean.setImageURL(getUploadFileName());
		LOGGER.debug(topoBean.getUploadFileName() + "==="); 
		
		topoBean.setPublished(Calendar.getInstance().getTime());
		LOGGER.debug(topoBean.getPublished() + "date d'ajout du topo");

		LOGGER.debug(((User) session.get(USER)).getIdUser());
		int idUser = ((User) session.get(USER)).getIdUser();

		topoBean = managerFactory.getTopoManager().addTopo(topoBean);
		managerFactory.getTopoManager().addJoinTopoSpot(topoBean.getIdTopo(), idSpot);
		managerFactory.getTopoManager().addJoinTopoUser(topoBean.getIdTopo(), idUser);

		vResult = ActionSupport.SUCCESS;
		return vResult;
	} */
	
	public String doAddTopo() {
		String vResult = ActionSupport.INPUT;	
		
		String uploadsPath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");  
		
		LOGGER.debug("uploads location: " + uploadsPath);
		
		 // copy the uploaded files into pre-configured location
        for (int i = 0; i < uploads.size(); i++) {
            File uploadedFile = uploads.get(i);
            String fileName = uploadFileNames.get(i);
            File destFile = new File(uploadsPath + File.separator + fileName);
            try {
                FileUtils.copyFile(uploadedFile, destFile);
            } catch (IOException ex) {
                System.out.println("Could not copy file " + fileName);
                ex.printStackTrace();
            }
        }
        
        //topoBean.setImageURL(uploadFileNames);
		LOGGER.debug(topoBean.getImageURL() + "==="); 
		
		topoBean.setPublished(Calendar.getInstance().getTime());
		LOGGER.debug(topoBean.getPublished() + "date d'ajout du topo");

		LOGGER.debug(((User) session.get(USER)).getIdUser());
		int idUser = ((User) session.get(USER)).getIdUser();

		topoBean = managerFactory.getTopoManager().addTopo(topoBean);
		managerFactory.getTopoManager().addJoinTopoSpot(topoBean.getIdTopo(), idSpot);
		managerFactory.getTopoManager().addJoinTopoUser(topoBean.getIdTopo(), idUser);

		
		vResult = ActionSupport.SUCCESS;
		return vResult;
	}

}
