import { useState } from 'react'
import LogForm from '../components/LogForm';
import EntryPreview from '../components/EntryPreview';
function HomePage() {
    const [entryData, setEntryData] = useState(null);

    return (
        <>
            <main>
                <div className="container">
                    <LogForm onSubmit={setEntryData}></LogForm>
                    <EntryPreview topEntry={entryData}></EntryPreview>
                </div>
            </main>
        </>
    )
}
export default HomePage