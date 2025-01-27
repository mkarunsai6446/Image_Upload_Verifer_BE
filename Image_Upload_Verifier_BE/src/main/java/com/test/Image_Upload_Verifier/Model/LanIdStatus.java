package com.test.Image_Upload_Verifier.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LanIdStatus {
    // Getters and Setters
    private String lanId;
    private boolean imageUploaded;


    // Getters and Setters
    public String getLanId() { return lanId; }
    public void setLanId(String lanId) { this.lanId = lanId; }

    public boolean isImageUploaded() { return imageUploaded; }
    public void setImageUploaded(boolean imageUploaded) { this.imageUploaded = imageUploaded; }

}
