import { useState } from 'react'
import './App.css'
import './styles/home.css'
import Header from './jsx/common/Header'
import Footer from './jsx/common/Footer'
import Entry from './jsx/common/Entry'
import LogForm from './jsx/common/LogForm'
import InputComponent from './jsx/examples/InputComponent'

function App() {
  const [isExample, setIsExample] = useState(false);
  const [entryData, setEntryData] = useState(null);

  return (
    <>
      <Header></Header>
      <main>
        <div className="container">
          {!isExample && (
            <LogForm onSubmit={setEntryData}></LogForm>
            )
          }
          {isExample && (
            <InputComponent></InputComponent>
            )
          }
          <Entry entryJSON={entryData}></Entry>
        </div>
      </main>
      <Footer></Footer>
    </>
  )
}

export default App
