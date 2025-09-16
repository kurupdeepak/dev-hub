import { useState } from "react"
function Entry(props) {
    console.log(props)
    const entry = props.entryJSON
    console.log(JSON.stringify(props.entryJSON, null, 2))
    const today = Date.now()
    return (
        <div className="entryPreview" id="preview">
            <h3>Entry Preview:</h3>
            <pre id="previewContent">
             {props.entryJSON  && <table><tr><td>{entry.day}</td><td>{entry.content}</td></tr></table>}
            </pre>
        </div>
    )
}
export default Entry