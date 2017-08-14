package com.znow.zetlogger;

class PrioritiesContainer {
	
	private boolean infoPriority = true;
	private boolean tracePriority = true;
	private boolean warningPriority = true;
	private boolean errorPriority = true;
	
	
	protected void setPrioritiesCustomizable() {
		setInfoPriority(false);
		setTracePriority(false);
		setWarningPriority(false);
		setErrorPriority(false);
	}
	
	protected boolean getInfoPriority() {
		return infoPriority;
	}
	
	protected void setInfoPriority(boolean infoPriority) {
		this.infoPriority = infoPriority;
	}

	protected boolean getTracePriority() {
		return tracePriority;
	}

	protected void setTracePriority(boolean tracePriority) {
		this.tracePriority = tracePriority;
	}

	protected boolean getWarningPriority() {
		return warningPriority;
	}

	protected void setWarningPriority(boolean warningPriority) {
		this.warningPriority = warningPriority;
	}

	protected boolean getErrorPriority() {
		return errorPriority;
	}

	protected void setErrorPriority(boolean errorPriority) {
		this.errorPriority = errorPriority;
	}
	
}
