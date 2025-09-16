import { useState } from "react"
function EntryPreview(props) {
    console.log(props)
    const entry = props.topEntry
    console.log(JSON.stringify(props.topEntry, null, 2))
    const today = Date.now()
    return (
        <div className="entryPreview" id="preview">
            <h3>Entry Preview:</h3>
            <pre id="previewContent">
             {entry  && <table><tbody><tr><td>{entry.day}</td><td>{entry.content}</td></tr></tbody></table>}
            </pre>
        </div>
    )
}
export default EntryPreview