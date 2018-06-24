import C from './constants'

// Will be useful in the future for making calls to the dispatcher

class Api {
    static getAll() {
        return fetch('https://localhost/feed').then(response => {
            return response.json();
        }).catch(error => {
            return error;
        });
    } }


function loadFeedSuccess(homeFeed) {
    return {type: C.LOAD_HOME_FEED, homeFeed};
}

export function loadFeed() {
    return function(dispatch) {
        return Api.getAll().then(cats => {
            dispatch(loadFeedSuccess(cats));
        }).catch(error => {
            throw(error);
        });
    };
}