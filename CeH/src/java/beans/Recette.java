/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author stag
 */
public class Recette implements Serializable {

    private static final long SerialVersionUid = 1L;

    private int id;
    private String title;
    private String ingredient;
    private String difficulty;
    private int noteUp;
    private int noteDown;
    private Date date;
    private String detail;

    public Recette() {
    }

    public Recette(int id, String title, String ingredient, String difficulty, int noteUp, int noteDown, Date date, String detail) {
        this.id = id;
        this.title = title;
        this.ingredient = ingredient;
        this.difficulty = difficulty;
        this.noteUp = noteUp;
        this.noteDown = noteDown;
        this.date = date;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNoteUp() {
        return noteUp;
    }

    public void setNoteUp(int noteUp) {
        this.noteUp = noteUp;
    }

    public int getNoteDown() {
        return noteDown;
    }

    public void setNoteDown(int noteDown) {
        this.noteDown = noteDown;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Recette{" + "id=" + id + ", title=" + title + ", ingredient=" + ingredient + ", difficulty=" + difficulty + ", noteUp=" + noteUp + ", noteDown=" + noteDown + ", date=" + date + ", detail=" + detail + '}';
    }

}
