import { ActionTypes } from '../actions/actionType';

export const userAuthReducer = (state = {isLoggedIn:false}, action) => {
     if(ActionTypes.LOGOUT_USER === action.type){
        state = undefined;
        return {...state,isLoggedIn:action.payload}
    }
    return state;
}