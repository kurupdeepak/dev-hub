import { useState } from 'react'
import LogForm from '../components/logform/LogForm';
import EntryPreview from '../components/preview/EntryPreview';
function HomePage() {
    const [entry, setEntry] = useState(null);

    return (
        <>
            <main>
                <div className="container">
                    <LogForm onEntry={setEntry}></LogForm>
                    <EntryPreview entry={entry}></EntryPreview>
                </div>
            </main>
        </>
    )
}
export default HomePage