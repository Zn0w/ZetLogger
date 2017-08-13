package com.znow.zetlogger;

class PrioritiesContainer {
	
	private boolean infoPriority;
	private boolean tracePriority;
	private boolean warningPriority;
	private boolean errorPriority;
	
	
	protected void setPriorityToAll() {
		setInfoPriority(true);
		setTracePriority(true);
		setWarningPriority(true);
		setErrorPriority(true);
	}
	
	protected boolean isInfoPriority() {
		return infoPriority;
	}
	
	protected void setInfoPriority(boolean infoPriority) {
		this.infoPriority = infoPriority;
	}

	protected boolean isTracePriority() {
		return tracePriority;
	}

	protected void setTracePriority(boolean tracePriority) {
		this.tracePriority = tracePriority;
	}

	protected boolean isWarningPriority() {
		return warningPriority;
	}

	protected void setWarningPriority(boolean warningPriority) {
		this.warningPriority = warningPriority;
	}

	protected boolean isErrorPriority() {
		return errorPriority;
	}

	protected void setErrorPriority(boolean errorPriority) {
		this.errorPriority = errorPriority;
	}
	
}
