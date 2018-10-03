
/**
 * Write a description of class BallRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BallRunner
{
    // Activity 1
    public static void activity1(){
        BallWorld ballWorld = new BallWorld(200,200);
        BallBot ballBot = new BallBot(ballWorld, new TGPoint(0,0),0,300);
        while (true){
            if (ballBot.canMoveForward(ballWorld) == true){
                ballBot.moveForward();
            }
            else{
                ballBot.setHeading(ballBot.getHeading()+45);
            }
        }
    }
    //Activity 2
    public static int findFreeBallBotIndex(BallBot[] ballBotArray){
        int returnValue = 0;
        for (int i = 0; i<ballBotArray.length; i++){
            if (ballBotArray[i] == null){
                returnValue = i;
            }
        }
        if (returnValue == 0){
            returnValue = ballBotArray.length;
        }
        return returnValue;
    }

    public static void activityTwo(){
        BallWorld ballWorld = new BallWorld(500,500);
        TGPoint entrancePoint = new TGPoint(0,0);
        BallBot[] ballBotArray = new BallBot[3];
        BallRunner ballRunner = new BallRunner();
        while(true){
            int n = ballRunner.findFreeBallBotIndex(ballBotArray);
            if (n < ballBotArray.length){
                ballBotArray[n] = new BallBot(ballWorld,entrancePoint,(Math.random()*360),400);
            }
            for (int a = 0; a< ballBotArray.length;a++){
                if(ballBotArray[a] != null){
                    if (ballBotArray[a].canMoveForward(ballWorld)){
                        ballBotArray[a].moveForward();
                    }else{
                        ballBotArray[a].setHeading(ballBotArray[a].getHeading()+35);
                    }
                }
            }
        }
    }

    //Activity 3
    public double distanceBetweenPoints(TGPoint point1, TGPoint point2){
        double point;
        double sqr = 2.0;
        point = Math.sqrt(Math.pow(point1.x-point2.x, sqr)- (Math.pow(point1.y-point2.y, sqr)));
        return point;
    }

}

