package main;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static main.Facto_enum.METEOR;

public class Launcher {
    private Position position = new Position(0,0);

    private List<Meteor> meteorlist = new ArrayList<>();


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Meteor> getMeteorlist() {
        return meteorlist;
    }

    public void setMeteorlist(List<Meteor> meteorlist) {
        this.meteorlist = meteorlist;
    }

    public void planetcrash(Planet p){

        double x1 = this.position.getX();
        double y1 = this.position.getY();

        double x2 = p.turnsim(100).getX();
        double y2 = p.turnsim(100).getY();

        double vx = (x2 - x1)/1000;
        double vy = (y2 - y1)/1000;


        thrownormal(vx,vy);
    }


    public void thrownormal(double x, double y){
        Speed s = new Speed(x,y);
        Position p = this.getPosition();
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.NORMAL);
        System.out.println(m.getSpeed().Xspeed);
        meteorlist.add(m);
    }

    public void throwkiller(){
        Speed s = new Speed(100000,100000);
        Position p = this.getPosition();
        Meteor m = Factorymeteor.facto_met(s,p,Meteor_type.TUEUR);
        meteorlist.add(m);
    }

    public void printmeteor() throws FileNotFoundException {
        for (Meteor m : this.meteorlist) {
            Singleton.getInstance().addjson(m.toJSON());
        }
    }
    public void turnmeteor(){
        for (Meteor m : this.meteorlist){
            m.travel(24);
        }
    }

    public void wcheckcollision(CorpsCeleste c) throws FileNotFoundException {
        for (Meteor m : this.meteorlist){
            m.checkcollision(c);
        }
    }

}
