import { useState } from "react"
function EntryPreview(props) {
    console.log(props)
    const entry = props.topEntry
    console.log(JSON.stringify(props.topEntry, null, 2))
    const today = Date.now()
    return (
        <div className="entryPreview" id="preview">
            <h3>Entry Preview:</h3>
            <pre id="previewContent" style={{
                fontSize: "0.75rem",        // small font
                whiteSpace: "nowrap",       // single line
                overflow: "hidden",         // crop if too long
                textOverflow: "ellipsis",   // ellipsis for long content
                width: "100%",
                display: "block"
            }}>
                {entry && JSON.stringify(entry)}
            </pre>
        </div>
    )
}
export default EntryPreview