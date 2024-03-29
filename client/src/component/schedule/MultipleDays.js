import  React from 'react';
import PropTypes from 'prop-types';
import Tabs from '@mui/material/Tabs';
import Tab from '@mui/material/Tab';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import { useState } from 'react';
import CustomForm from './CustomForm';

function TabPanel(props) {
  const { children, value, index, ...other } = props;

  return (
    <div
      role="tabpanel"
      hidden={value !== index}
      id={`vertical-tabpanel-${index}`}
      aria-labelledby={`vertical-tab-${index}`}
      {...other}
    >
      {value === index && (
        <Box sx={{ p: 3 }} component={"div"}>
          <Typography  component={"span"}>{children}</Typography>
        </Box>
      )}
    </div>
  );
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.number.isRequired,
  value: PropTypes.number.isRequired,
};

function a11yProps(index) {
  return {
    id: `vertical-tab-${index}`,
    'aria-controls': `vertical-tabpanel-${index}`,
  };
}

export default function MultipleDays() {
  const [value, setValue] = useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <Box
    component={"div"}
    
      sx={{ flexGrow: 1, bgcolor: 'background.paper', display: 'flex', height: 224,width:"80%",alignItems:"center" ,justifyContent:"space-between"}}
    >
      <Tabs
        orientation="vertical"
        variant="scrollable"
        value={value}
        onChange={handleChange}
        aria-label="Vertical tabs example"
      
        sx={{ borderRight: 1, borderColor: 'divider' }}
      >
        <Tab label="Custom" {...a11yProps(0)} />
        <Tab label="Current Week" {...a11yProps(1)} />
        <Tab label="Next Week" {...a11yProps(2)} />
         
      </Tabs>
      <TabPanel value={value} index={0} >
        <CustomForm />
      </TabPanel>
      <TabPanel value={value} index={1}>
        Item Two
      </TabPanel>
      <TabPanel value={value} index={2}>
        Item Three
      </TabPanel>
  
    </Box>
  );
}
