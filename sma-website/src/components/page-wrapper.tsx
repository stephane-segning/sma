import {PropsWithChildren, ReactNode} from "react";

interface PageWrapperProps {
    title: string;
    rightTitle?: ReactNode;
}

export function PageWrapper({children, title, rightTitle}: PropsWithChildren<PageWrapperProps>) {
    return (
        <div className='container px-2 mt-2 mx-auto'>
            <div className='flex justify-between gap-4'>
                <h1 className='text-4xl font-bold'>{title}</h1>
                {rightTitle}
            </div>

            {children}
        </div>
    )
}