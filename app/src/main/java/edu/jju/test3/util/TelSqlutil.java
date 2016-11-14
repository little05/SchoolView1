package edu.jju.test3.util;


public class TelSqlutil {
/**
 *
 */
    private String group_name;
	private String child_name;
	private String child_tel;

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getChild_name() {
		return child_name;
	}

	public void setChild_name(String child_name) {
		this.child_name = child_name;
	}

	public String getChild_tel() {
		return child_tel;
	}

	public void setChild_tel(String child_tel) {
		this.child_tel = child_tel;
	}

	public TelSqlutil() {
		super();
	}


	@Override
	public String toString() {
		return "TelSqlutil{" +
				"group_name='" + group_name + '\'' +
				", child_name='" + child_name + '\'' +
				", child_tel='" + child_tel + '\'' +
				'}';
	}
}
