package calendar.daydream.data;

public class CalendarAttendee implements Comparable<CalendarAttendee> {

	private String name;
	private String email;
	private int relationship;
	private int status;
	
	public CalendarAttendee(String name, String email, int relationship,
			int status) {
		super();
		this.name = name;
		this.email = email;
		this.relationship = relationship;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRelationship() {
		return relationship;
	}

	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int compareTo(CalendarAttendee other) {
		//TODO might need to add email fallback
		return this.getName().compareToIgnoreCase(other.getName());
	}
	
}
