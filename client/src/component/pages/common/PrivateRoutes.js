import React from "react";
import { Route, Redirect } from "react-router-dom";
import { useSelector } from "react-redux";
import { isLogin } from "./IsLoggedInUser";

const PrivateRoute = ({ component: Component, ...rest }) => {
	const isLoggedInUser = useSelector((state) => state.userAuth.isLoggedIn);
	return (
		<Route
			{...rest}
			render={(props) =>
				isLogin() && isLoggedInUser ? (
					<Component {...props} />
				) : (
					<Redirect to="/" />
				)
			}
		/>
	);
};

export default PrivateRoute;
