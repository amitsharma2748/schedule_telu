import { ActionTypes } from "./actionType";

export const logout = () => (dispatch) => {
  dispatch({ type: ActionTypes.LOGOUT_USER, payload: false });
};
