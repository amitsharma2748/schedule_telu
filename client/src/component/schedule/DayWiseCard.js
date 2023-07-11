import React, { useState } from 'react'
import "../../styles/schedule.css"
import { Card, Typography } from '@mui/material'
import ModalSchedule from './ModalSchedule';
import EditIcon from '@mui/icons-material/Edit';
const DayWiseCard = (props) => {
    const {editable}=props;
    const [modalOpen,setModalOpen]=useState(false)
    const modalHandler=()=>{
          setModalOpen(true)
    }
  return (
   
    <Card sx={{margin:"15px"}}>
    <div className='daywise-body'>
        <div className='daywise-body-card-content-1'>
            <Typography component={"span"} variant='h5'>
            Mon 10 Jul
            </Typography>
            <span onClick={modalHandler}>
            <EditIcon/>
            </span>
        

        </div>
        <div className='daywise-body-card-content-2'>
             
                  <div>
                   <Typography component={"span"} variant='subtitle1'>Office Arrival Time:🚕 06:30 (0630HrsTO1530Hrs)</Typography>
                    
                    <Typography component={"span"} variant='subtitle1'>Drop not Required</Typography>
                    </div> 
                    <div>
                  <Typography component={"span"} variant='subtitle1'>Office Arrival Time:🚕 06:30 (0630HrsTO1530Hrs)</Typography>
                    <Typography component={"span"} variant='subtitle1'>Drop not Required</Typography>
                    </div>  
             
        </div>
        <div className='daywise-body-card-content-3'>
            <div>
                <h3>
                Created:
                </h3>
                <p>Airbnb Transport (08 Jul 16:00)</p>
            </div>
            <div>
                <h3>
                Modified:
                </h3>
                <p>Airbnb Transport (08 Jul 16:00)</p>
            </div>
        </div>
        </div>
        <ModalSchedule open={modalOpen} close={setModalOpen}/>
    </Card>
  )
}

export default DayWiseCard  