package main;

import java.io.FileNotFoundException;

public class Meteor{
    int id;
    int cid = 1;
    Meteor_type type;
    Speed speed;
    Position position;

    public Meteor(Position position, Meteor_type type, Speed speed) {
        this.id = cid;
        cid++;
        this.position = position;
        this.type = type;
        this.speed = speed;
    }

    public Meteor_type getType() {
        return type;
    }

    public void setType(Meteor_type type) {
        this.type = type;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void travel(int t){
        this.position.setX(this.position.getX()+(this.getSpeed().Xspeed*t));
        this.position.setY(this.position.getY()+(this.getSpeed().Yspeed*t));
    }

    public void checkcollision(CorpsCeleste c) throws FileNotFoundException {
        if(this.position.getX() <= c.getPosition().getX() + (double)c.getSize() && this.position.getY() <= c.getPosition().getY() + (double)c.getSize() ){
            Singleton.getInstance().printcollision(c);
        }
    }

    public String toJSON(){
        return "{'x':"+this.getPosition().getX()+", 'y':"+this.getPosition().getY()+"}";
    }



}
