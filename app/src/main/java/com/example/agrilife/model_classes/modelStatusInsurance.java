package com.example.agrilife.model_classes;


public class modelStatusInsurance
{
    insuranceModel model=new insuranceModel();
    String status="";

    public modelStatusInsurance(){};

    public modelStatusInsurance(insuranceModel model,String status)
    {
        this.model=model;
        this.status=status;
    }

    public insuranceModel getModel() {
        return model;
    }

    public void setModel(insuranceModel model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
