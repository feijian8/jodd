// Copyright (c) 2003-2013, Jodd Team (jodd.org). All Rights Reserved.

package jodd.vtor.constraint;

import jodd.datetime.JDateTime;
import jodd.typeconverter.Convert;
import jodd.vtor.ValidationConstraint;
import jodd.vtor.ValidationConstraintContext;

public class TimeBeforeConstraint implements ValidationConstraint<TimeBefore> {

	public TimeBeforeConstraint() {
	}

	public TimeBeforeConstraint(JDateTime time) {
		this.time = time;
	}

	// ---------------------------------------------------------------- properties

	protected JDateTime time;

	public JDateTime getTime() {
		return time;
	}

	public void setTime(JDateTime time) {
		this.time = time;
	}

	// ---------------------------------------------------------------- configure

	public void configure(TimeBefore annotation) {
		time = new JDateTime(annotation.value());
	}

	// ---------------------------------------------------------------- validate

	public boolean isValid(ValidationConstraintContext vcc, Object value) {
		return validate(value, time);
	}

	public static boolean validate(Object value, JDateTime then) {
		if (value == null) {
			return true;
		}
		JDateTime now = Convert.toJDateTime(value);
		return now.isBefore(then);
	}
}
