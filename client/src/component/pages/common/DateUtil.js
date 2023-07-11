export const dateUtil = (startDate, endDate, type) => {
	if ("getDays" === type) {
		let diffInMs = Math.abs(new Date(endDate) - new Date(startDate));
		return diffInMs / (1000 * 60 * 60 * 24);
	}
};
