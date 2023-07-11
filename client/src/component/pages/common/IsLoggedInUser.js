const TOKEN_KEY = 'accessToken';
export const login = (accessToken) => {
    sessionStorage.setItem(TOKEN_KEY, accessToken);
}

export const logout = () => {
    sessionStorage.removeItem(TOKEN_KEY);
}

export const isLogin = () => {
    if (sessionStorage.getItem(TOKEN_KEY)) {
        return true;
    }
    return false;
}
export const getToken = () => {
    return sessionStorage.getItem(TOKEN_KEY);
}
