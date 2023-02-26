package seminar06v2Final;

public class Notebook {

    private String article;        // Article
    // CPU
    private String lineCPU;    // CPU's family
//    private int cpuKernels;      // Number kernels of the CPU
//    private String cpuFactory;  // CPU manufacturer

    private String dimm;           // DIMM, Gb
    private String ssd;            // Volume SSD, Gb
//    private String graphicCard; // Discrete graphic card model or no

    // Screen
    private String diagonal;       // Screen's diagonal, inch
//    private String typeScreen;; // Model of matrix

    // Notebook
    private String manufacturer; // Manufacturer of a notebook
    private String model;       // Model notebook
//    private boolean game;       // Gaming: yes, no
    private String colour;
//    private String typeNotebook; // Notebook or ultrabook
    private String os;          // OS: Windows, Linux, no OS
//    private int reliability;    // %
//    private double rating;      // Rating of the feedbacks
    private String cost;        // Cost, rub


    // Constructor, принимает на вход процессор, ОЗУ, SSD...
    public Notebook(String article, String lineCPU, String dimm, String ssd, String diagonal, String manufacturer,
                    String model, String colour, String os, String cost) {
        this.article = article;
        this.lineCPU = lineCPU;
        this.dimm = dimm;
        this.ssd = ssd;
        this.diagonal = diagonal;
        this.manufacturer = manufacturer;
        this.model = model;
        this.colour = colour;
        this.os = os;
        this.cost = cost;
    }

    public String toString() {
        return String.format("%s/%s/%s/%s/%s/%s/%s/%s/%s/%s", this.article, this.lineCPU, this.dimm, this.ssd, this.diagonal,
                this.manufacturer, this.model, this.colour, this.os, this.cost);
    }

    public String getArticle() {
        return this.article;
    }

    public String getLineCPU() {
        return this.lineCPU;
    }

    public String getDimm() {
        return this.dimm;
    }

    public String getSsd() {
        return this.ssd;
    }

    public String getDiagonal() {
        return this.diagonal;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getColour() {
        return this.colour;
    }

    public String getOs() {
        return this.os;
    }

    public String getCost() {
        return this.cost;
    }

    public String getParams(String params) {
        switch (params) {
            case "article": return this.article;
            case "lineCPU": return this.lineCPU;
            case "dimm": return this.dimm;
            case "ssd": return this.ssd;
            case "diagonal": return this.diagonal;
            case "manufacturer": return this.manufacturer;
            case "model": return this.model;
            case "colour": return this.colour;
            case "os": return this.os;
            case "cost": return this.cost;
        }
        return "";
    }

    public void setArticle(String article) {
        this.article = article;
        return;
    }

    public void setLineCPU(String lineCPU) {
        this.lineCPU = lineCPU;
        return;
    }

    public void setDimm(String dimm) {
        this.dimm = dimm;
        return;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
        return;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
        return;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return;
    }

    public void setModel(String model) {
        this.model = model;
        return;
    }

    public void setColour(String colour) {
        this.colour = colour;
        return;
    }

    public void setOs(String os) {
        this.os = os;
        return;
    }

    public void setCost(String cost) {
        this.cost = cost;
        return;
    }
}
