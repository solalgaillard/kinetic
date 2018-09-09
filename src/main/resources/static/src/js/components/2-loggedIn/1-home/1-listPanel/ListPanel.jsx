import React, {Component} from 'react'
import cx from "classnames";
import styles from './list-panel.sass'
import {connect} from "react-redux";


const ListPanelPre = ({lists, styleName}) =>
    <div className={cx(styles['list-panel'], styleName)}>
        <h3>user's list</h3>
        <hr />
            <ul>
                {lists.admin.map( (list, i) =>
                    <li key={i}>
                        {`~${list.listName}`}
                        <img src='src/img/common/expand-icon.png'/>
                        <hr />
                    </li>
                    )
                }
            </ul>
        <hr />
        <h3>shared lists</h3>
        <ul>
            {lists.shared.map( (list, i) =>
                <li key={i}>
                    {`~${list.listName}`}
                    <img src='src/img/common/expand-icon.png'/>
                    <hr />
                </li>
            )
            }
        </ul>
        <hr />
        <h3>followed lists</h3>

        <ul>
            {lists.shared.map( (list, i) =>
                <li key={i}>
                    {`~${list.listName}`}
                    <img src='src/img/common/expand-icon.png'/>
                    <hr />
                </li>
            )
            }
        </ul>
        <hr />
        <h3>create list</h3>
    </div>

export const ListPanel = connect (
    state =>
        ({
            lists: state.user.lists
        }),
    null
)(ListPanelPre)
