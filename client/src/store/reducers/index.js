import { combineReducers } from "redux";
import { reducer as formReducer } from "redux-form";
import { persistReducer } from "redux-persist";
import storage from "redux-persist/lib/storage/session";
import { encryptTransform } from "redux-persist-transform-encrypt";
import { userAuthReducer } from "./UserAuthReducer";
import { ActionTypes } from "../actions/actionType";

const encryptor = encryptTransform({
	secretKey: "HTS-Secret-Key",
	onError: function (error) {
		console.log("Error in creating Encryptor ", error);
	},
});

const persistConfig = {
	key: "root",
	storage,
	transforms: [encryptor],
};

const appReducer = combineReducers({
	form: formReducer,
	userAuth: userAuthReducer
});

const rootReducer = (state, action) => {
	if (ActionTypes.LOGOUT_USER === action.type) {
		state = undefined;
	}
	return appReducer(state, action);
};

export default persistReducer(persistConfig, rootReducer);
