function EntriesView() {
    function toggleEntries(header) {
        const entries = header.nextElementSibling;
        entries.style.display = entries.style.display === 'block' ? 'none' : 'block';
    }
    return (
        <>
            <main>
                <div className="container">
                    <h1>TrackMe - Entries by Day</h1>
                    <div className="day-group">
                        <div className="day-header" onClick={toggleEntries}>September 15, 2025</div>
                        <div className="entries">
                            <div className="entry">
                                <strong>Category:</strong> Thoughts<br />
                                <strong>Time:</strong> 08:45 AM<br />
                                <strong>Note:</strong> Felt really focused this morning.
                            </div>
                            <div className="entry">
                                <strong>Category:</strong> Food<br />
                                <strong>Time:</strong> 01:30 PM<br />
                                <strong>Note:</strong> Had oats and fruit for lunch.
                            </div>
                        </div>
                    </div>
                    <div className="day-group">
                        <div className="day-header" onClick={toggleEntries}>September 14, 2025</div>
                        <div className="entries">
                            <div className="entry">
                                <strong>Category:</strong> Glucose Reading<br />
                                <strong>Time:</strong> 07:00 AM<br />
                                <strong>Note:</strong> 125 mg/dL fasting.
                            </div>
                            <div className="entry">
                                <strong>Category:</strong> Physical Activity<br />
                                <strong>Time:</strong> 06:00 PM<br />
                                <strong>Note:</strong> 45-minute treadmill walk.
                            </div>
                        </div>
                    </div>
                </div>
            </main >
        </>
    )
}

export default EntriesView