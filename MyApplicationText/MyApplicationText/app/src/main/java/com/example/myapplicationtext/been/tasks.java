package com.example.myapplicationtext.been;

public class tasks {
    private int mid;
    private String mtitle;
    private String mDescription;
    private int mchecked;

    public tasks(int mid, String mtitle, String mDescription, int mchecked) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.mDescription = mDescription;
        this.mchecked = mchecked;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getMchecked() {
        return mchecked;
    }

    public void setMchecked(int mchecked) {
        this.mchecked = mchecked;
    }
}
