package com.example.agrilife.model_classes;

public class modelStatusLoan
{
    FinancingPlansModel model=new FinancingPlansModel();
    String status="";

    public modelStatusLoan(){};

    public modelStatusLoan(FinancingPlansModel model,String status)
    {
        this.model=model;
        this.status=status;
    }

    public FinancingPlansModel getModel() {
        return model;
    }

    public void setModel(FinancingPlansModel model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
