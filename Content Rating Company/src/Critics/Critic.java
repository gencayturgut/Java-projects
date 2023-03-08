package Critics;

public abstract class Critic{
	private double opinion;
	private int turnNo;
	
	public Critic() {
		this(0,0);
	}
	public Critic(double opinion,int no) {
		setOpinion(opinion);
		setTurnNo(no);
	}
	public Critic(Critic critic) {
		this(critic.getOpinion(),critic.getTurnNo());
	}
	
	public void setOpinion(double opinion) {
		this.opinion = opinion;
	}

	public double getOpinion() {
		return opinion;
	}
	public abstract <T> double calculateRating(T content);
	
	public int getTurnNo() {
		return turnNo;
				
	}
	
	public void setTurnNo(int no) {
		turnNo=no;
	}
	
}
