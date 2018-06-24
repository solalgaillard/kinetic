import C from './constants'

//For a future API call, action stub to load from server the background images
export const backgroundImages = (state=[], action) => {
    return state
}

export const user = (state={}, action) => {
    switch (action.type) {
        case C.LOAD_MAIN_USER:
            return action.user
        default:
            return state
    }
}

export const homeFeed = (state=[], action) => {
    switch (action.type) {
        case C.LOAD_HOME_FEED:
            return action.homeFeed
        default:
            return state
    }
}