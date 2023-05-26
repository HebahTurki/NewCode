package ustudy;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PC
 */
public class LearningMaterial {

    int ID;
    String name;
    String flag;
    int page_number;
    Subject subject;
    ArrayList<LearningMaterial> LM = new ArrayList<>();
    int pages_done;

    public LearningMaterial() {
    }

    public LearningMaterial(Subject subject, int ID, String name, String flag, int page_number) {
        this.subject = subject;
        this.ID = ID;
        this.name = name;
        this.flag = flag;
        this.page_number = page_number;
    }

    public LearningMaterial(Subject subject, int ID, String name, int page_number) {
        this.subject = subject;
        this.ID = ID;
        this.name = name;
        this.page_number = page_number;

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getPage_number() {
        return page_number;
    }

    public void setPage_number(int page_number) {
        this.page_number = page_number;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ArrayList<LearningMaterial> getLM() {
        return LM;
    }

    public void setLM(ArrayList<LearningMaterial> LM) {
        this.LM = LM;
    }

    public int getPages_done() {
        return pages_done;
    }

    public void setPages_done(int pages_done) {
        this.pages_done = pages_done;
    }

    public void addLearningMaterial(LearningMaterial lm) {
        LM.add(lm);
    }

    public void calculateFlag(LearningMaterial lm) {

        if (lm.getPages_done() > 0
                && lm.getPages_done() < lm.getPage_number()) {
            lm.setFlag("In Progress");
        }
        if (lm.getPages_done() == lm.getPage_number()) {
            lm.setFlag("Completed");
        } 
        if(lm.getPages_done() == 0) {
            lm.setFlag("Not Started");
        }

    }

    public void viewMaterial(Subject subject) {
        int numOfM = 0;
        for (int i = 0; i < LM.size(); i++) {
            if (subject == LM.get(i).subject) {
                calculateFlag(LM.get(i)); //calc flag every view
                System.out.println((++numOfM) + "\t\tMaterial ID: "
                        + LM.get(i).getID() + " Material Name: "
                        + LM.get(i).getName()
                        + "  Pages: " + LM.get(i).getPages_done() + "/" + LM.get(i).getPage_number()
                        + "  Flag: " + LM.get(i).getFlag());
            }
        }

    }

    public boolean existMaterial(int id) {
        boolean found = false;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getID()) {
                return found = true;
            }
        }
        return found;
    }

    public void deleteMaterial(int id) {
        boolean found = false;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getID()) {
                found = true;
                LM.remove(i);
                System.out.println("Learning Material Deleted Sucessfuly\n");
            }
        }
        if (!found) {
            System.out.println("Learning Material ID is not found!\n");
        }
    }

    public LearningMaterial getLMbyId(int id) {
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getID()) {
                return LM.get(i);
            }
        }
        return null;
    }

    public int pagesDoneforSubject(int id) {
        int total = 0;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getSubject().getId()) {
                total += LM.get(i).getPages_done();
            }
        }
        return total;
    }

    public int totalPagesforSubject(int id) {
        int total = 0;
        for (int i = 0; i < LM.size(); i++) {
            if (id == LM.get(i).getSubject().getId()) {
                total += LM.get(i).getPage_number();
            }
        }
        return total;
    }
}
