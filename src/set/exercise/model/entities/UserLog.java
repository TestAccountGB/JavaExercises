package set.exercise.model.entities;

import java.util.Date;
import java.util.Objects;

public class UserLog {

	private String name;
	private Date lastTimeOn;

	public UserLog(String name, Date lastTimeOn) {
		this.name = name;
		this.lastTimeOn = lastTimeOn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastTimeOn() {
		return lastTimeOn;
	}

	public void setLastTimeOn(Date lastTimeOn) {
		this.lastTimeOn = lastTimeOn;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLog other = (UserLog) obj;
		return Objects.equals(name, other.name);
	}

}
