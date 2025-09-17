// import { useState } from "react"
import './EntryPreview.css'
function EntryPreview(props) {
    const {entry} = props;
    console.log("Inside EntryPreview ",JSON.stringify(entry, null, 2))
    return (
        <div>
            {entry &&
                <ul className="horizontal-list">
                    <li><strong>1</strong></li>
                    <li><strong>Day:</strong>{entry.day}</li>
                    <li><strong>Entry:</strong>{entry.content}</li>
                </ul>
            }
        </div>
    )
}
export default EntryPreview