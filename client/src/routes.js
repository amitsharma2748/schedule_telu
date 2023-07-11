import React, { Component } from "react";
import { Switch } from "react-router-dom";
import PublicRoutes from "./component/pages/common/PublicRoutes";
import HomePage from "./component/pages/HomePage";

class Routes extends Component {
	constructor(props) {
		super(props);
		if (typeof window === "undefined") {
			global.window = {};
		}
	}

	render() {
		return (
			<div>
				<Switch>
					<PublicRoutes restricted={false} path="/" exact component={HomePage} />
				</Switch>
			</div>
		);
	}
}
export default Routes;
