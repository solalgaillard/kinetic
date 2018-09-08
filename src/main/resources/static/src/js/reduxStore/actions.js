import C from './constants'
import ApiCalls from '../utils/ApiCalls'



//================================================================================
// User key - A dictionary
//
//================================================================================

export function loadUser(json, connectionType) {
    return function(dispatch) {
        return ApiCalls.postAll('https://localhost/authenticate', json, connectionType)
            .then(response => {
                if (response.ok)
                    return response.json()
            })
            .then(data => {
                dispatch(loadUserSuccess(data))
                //dispatch(loadAuthenticationStatus())
            })
            .catch(error => {
                console.log(error)
            })

    }
}

function loadUserSuccess(userAll) {
    const { userToken, ...user } = userAll
    localStorage.setItem("accessToken", userToken)
    console.log(user)
    return {type: C.LOAD_MAIN_USER, user}
}

/*
function loadAuthenticationStatus() {
    var authenticated = true
    return {type: C.IS_USER_AUTH, authenticated}
}
*/


//================================================================================
// feed key - A dictionary
//
//================================================================================

function loadFeedSuccess(feed) {
    return {type: C.LOAD_FEED, feed};
}

export function loadFeed() {
    return function(dispatch) {
        return ApiCalls.getAll('https://localhost/feed')
            .then(response => {
                if (response.ok)
                    return response.json()
            })
            .then(data => {
                dispatch(loadFeedSuccess(data))
                //dispatch(loadAuthenticationStatus())
            })
            .catch(error => {
                console.log(error)
            })
    }
}
