import { Box, MenuItem, Modal, Select } from '@mui/material'
import React, { useState } from 'react'
import "../../styles/modalSchedule.css"
const ModalSchedule = (props) => {
  const {open,close}=props
    const [data, setData] = useState([]);
    let newData={};
    const handleClose=()=>{
      close(false)
    }
    const style = {
      position: 'absolute',
      top: '50%',
      left: '50%',
      transform: 'translate(-50%, -50%)',
      width: 400,
      bgcolor: 'background.paper',
      border: '2px solid #000',
      boxShadow: 24,
      pt: 2,
      px: 4,
      pb: 3,
    };
    
    const handleChange = (event) => {
       newData[event.target.name]=event.target.value
      setData(data=>[...data,newData]);
      console.log(data,newData)
    };
  return (
  
          <Modal
    open={open}
    onClose={handleClose}
    aria-labelledby="parent-modal-title"
    aria-describedby="parent-modal-description"
    className='modal-schedule'
    
  >
    <Box component={"div"}  className="modal-schedule-container" sx={{ ...style, width: 200 }}>
      <div>
      <h1>
        Edit
       </h1>
      </div>
       
     
    </Box>
  </Modal>
 
  )
}

export default ModalSchedule    