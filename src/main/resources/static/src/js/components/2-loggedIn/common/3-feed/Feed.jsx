import { connect } from "react-redux"
import {loadFeed, addToFeed} from '../../../../reduxStore/actions'
import React, {Component} from 'react'
import cx from "classnames";
import styles from './feed.sass'



export class FeedPre extends Component {

    constructor(props) {
        super(props)
        this.state = {typing: false}
        const {loadFeedItems} = this.props
        loadFeedItems()
    }

    showIcon = () => {
        this.setState({typing: true});
    }

    hideIcon = () => {
        //this.setState({typing: false});
    }

    render() {

        const {feed, styleName, writeFeedItem} = this.props
        const {typing} = this.state
        return (
            <div className={cx(styles.feed, styleName)}>
                <div className={styles['write-box']}>
                    <textarea onFocus={() => this.showIcon()} onBlur={() => this.hideIcon()} ref="_post" >Post To Feed</textarea>
                    {typing && <img onClick={() => writeFeedItem(JSON.stringify([this.refs._post.value]))} src="src/img/common/write-icon.png" />}
                </div>
                <main>
                    {feed.map( (post, i) =>
                        <div key={i}>
                            <img src={post.userPicture}/>
                            <h1>{post.userName}</h1>
                            <p>
                                {post.message.map( (message, z) =>
                                    (typeof message === 'object') ?
                                            <span className={Object.keys(message)[0]}
                                                  key={z}>{message[Object.keys(message)[0]]}</span>
                                            :
                                            message
                                )}
                            </p>


                        </div>
                    )}
                </main>
            </div>

        )
    }
}



export const Feed = connect (
    state =>
        ({
            feed: state.feed
        }),
    dispatch => ({
        loadFeedItems() {
            dispatch(loadFeed())
        },
        writeFeedItem(post) {
            dispatch(addToFeed(post))
        }
        })
)(FeedPre)
