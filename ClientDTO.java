package com.college.project.dto;

public class ClientDTO {
	
	  private int ClientId;
	    private String image;
	    private String name;
	    private String description;
	    private String designation;
	    
		public int getClientId() {
			return ClientId;
		}
		public void setClientId(int clientId) {
			ClientId = clientId;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
	    
		

}
