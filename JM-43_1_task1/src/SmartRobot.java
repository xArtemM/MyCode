public class SmartRobot extends Robot {

    public int StepCount;

    @Override
    public void moveRight() {
        super.moveRight();
        StepCount++;
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        StepCount++;
    }

    @Override
    public void moveUp() {
        super.moveUp();
        StepCount++;
    }

    @Override
    public void moveDown() {
        super.moveDown();
        StepCount++;
    }

    public int getStepsCount() {
        return StepCount;
    }
}