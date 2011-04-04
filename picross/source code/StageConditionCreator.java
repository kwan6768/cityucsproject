package picross;

/**
 * StageConditionCreator is the interface to create condition of stage selection menu
 * @version Release 1.08 1 Apr 2011
 * @author Ben Chan
 */
public interface StageConditionCreator {
	/**
	 * Create condition of the stage selection menu
	 * @param condition The object of the condition on stage selection menu
	 */
	public void createCondition(StageCondition condition);
}