import React from "react";
import ReactDOM from "react-dom";
// import './index.css';
import Routes from "./routes";
import { Router } from "react-router-dom";
import Root from "./Root";
import history from "./history";
import { disableReactDevTools } from "@fvilers/disable-react-devtools";

if (process.env.NODE_ENV === "production") {
	disableReactDevTools();
}

const initialState = window.__PRELOADED_STATE__
	? window.__PRELOADED_STATE__
	: {};

ReactDOM.hydrate(
	<Router history={history}>
		<Root>
			<Routes store={initialState} />
		</Root>
	</Router>,
	document.getElementById("app")
);
