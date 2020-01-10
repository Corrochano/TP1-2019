package tp.p2.p3.logic.objects;

import tp.p2.p3.exceptions.CommandExecuteException;

public interface IPlayerController {
	// PLAYER ACTIONS
	public void move (int numCells) throws CommandExecuteException;
	public void shootLaser() throws CommandExecuteException;
	public void shockWave() throws CommandExecuteException;
	public void shootSuperLaser() throws CommandExecuteException;
	// CALLBACKS
	public void receivePoints(int points);
	public void enableShockWave();
	public void enableMissile();
}