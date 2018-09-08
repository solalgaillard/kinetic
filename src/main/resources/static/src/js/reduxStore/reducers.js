import C from './constants'

//================================================================================
// Properties
//
//================================================================================

//For a future API call, action stub to load from server the background images
export const backgroundImages = (state=[], action) => {
    return state
}

//================================================================================
// Properties
//
//================================================================================

/*
export const authenticated = (state=false, action) => {
    console.log(action)
    switch (action.type) {
        case C.IS_USER_AUTH:
            return action.authenticated
        default:
            return state
    }
}*/

export const user = (state=null, action) => {
    switch (action.type) {
        case C.LOAD_MAIN_USER:
            return action.user
        default:
            return state
    }
}

//================================================================================
// Properties
//
//================================================================================

export const feed = (state=[], action) => {
    switch (action.type) {
        case C.LOAD_FEED:
            return action.feed
        default:
            return state
    }
}